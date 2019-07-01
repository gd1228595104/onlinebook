package util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import test.Emailutil;
import util.msgBean.Message;
import util.msgBean.UserInfo;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/websocket/{username}")
public class MyWebSocket {
    private static int onlineCount = 0;
    private static Map<UserInfo, MyWebSocket> webSockets = new ConcurrentHashMap<>();
    private Session session;
    private UserInfo user;
    private static int id = 0;
     @OnOpen
     public void onOpen(@PathParam("username") String username, Session session){
         user = new UserInfo(id+1,username);
         List<Message> list = new ArrayList<>();
         user.setMegs(list);
         this.session = session;
         addOnlineCount();
         webSockets.put(user,this);
         //获取所有用户
         Set<UserInfo> userKey = webSockets.keySet();
         String userInfoList = JSON.toJSONString(userKey);
         sendMessage(userInfoList,"",false);
         System.out.println(user.getName()+"加入连接,"+ JSON.toJSONString(userKey));
     }
     @OnClose
     public void onClose(){
         webSockets.remove(this);
         subOnlineCount();
         System.out.println("有用户退出，当前在线人数为"+getOnlineCount());
     }
     @OnMessage
     public void onMessage(String message,Session session){
         System.out.println("来自客户端的消息："+message);
         Message message1 = JSONObject.parseObject(message,new TypeReference<Message>(){});
         user.getMegs().add(message1);
         sendMessage(message1.getMessageText(),message1.getToName(),true);
     }
     @OnError
     public void onError(Session session, Throwable error){
         System.out.println("发生错误");
         error.printStackTrace();
     }

    /**
     *onlineContaint标记是否发送在线用户列表，true发送文本信息内容，false发送在线列表
     */
     public void sendMessage(String message,String to,boolean onlineContaint){
        //标记用户是否在线
        if(onlineContaint) {
            boolean flag = true;
            for (MyWebSocket item : webSockets.values()) {
                if (item.user.getName().equals(to)) {
                    //如果用户在线，则为false，不执行邮件功能
                    flag = false;
                    String content = user.getName() + ":" + message;
                    item.session.getAsyncRemote().sendText(content);
                }
            }
            if (flag) {
                String content = user.getName() + ":" + message;
                sendMail(content);
            }
        }else {
            for(MyWebSocket item : webSockets.values()){
                String content = "***"+message;
                item.session.getAsyncRemote().sendText(content);
            }
        }
    }


     public static synchronized  int getOnlineCount(){
         return onlineCount;
     }
     public static synchronized void addOnlineCount(){
         MyWebSocket.onlineCount++;
     }
     public static synchronized void subOnlineCount(){
         MyWebSocket.onlineCount--;
     }
    /**
     * 模拟邮件
     */
    private void sendMail(String msg){
        //邮件发送人邮箱
        Emailutil emailutil = new Emailutil();
        emailutil.setFrom("dawnwoo123@163.com");
        //收件人邮箱
        emailutil.setTo("240665014@qq.com");
        //平台类型
        emailutil.setType("smtp.163.com");
        emailutil.setUsername("dawnwoo123");
        emailutil.setPassword("dawnwoo123");
        //邮件主题
        emailutil.setSubject("友书提醒");
        emailutil.setInfo(msg);
        emailutil.send();
    }
}
