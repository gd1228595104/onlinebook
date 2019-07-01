  $(document).ready(function () {
      $.extend({
          getUrlParam:function(name){
              var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
              var r = window.location.search.substr(1).match(reg);
              if (r != null) return unescape(r[2]); return null;
          }
      })



      var userid = null;
      $.ajax({
          url:"getLoginInfo.action",
          method:"GET",
          async:false,
          success:function (data) {
              userid = data.sid;
          }
      })
      var stuId = $.getUrlParam("stuid");  //记录信息接收者的学号
      $("#toName").text(stuId);
      var websocket = null;
      //WebSocket
      //判断当前浏览器是否支持WebSocket
      if ('WebSocket' in window) {
          websocket = new WebSocket("ws://localhost:8080/websocket/"+userid);
      }
      else {
          alert('当前浏览器 Not support websocket')
      }

      //连接发生错误的回调方法
      websocket.onerror = function () {
          setMessageInnerHTML("WebSocket连接发生错误");
      };

      //连接成功建立的回调方法
      websocket.onopen = function () {
          setMessageInnerHTML("WebSocket连接成功");
      }

      //接收到消息的回调方法
      websocket.onmessage = function (event) {
          var data = event.data;
          var str = data.substring(0,3);
          var content = data.substring(3);
          if("***" === str){
              obj = JSON.parse(content)
              var innerContent = "";
              for(i = 0; i < obj.length; i++){
                  innerContent += "<li class=\"list-group-item\" id='"+i+"' onclick='fun("+i+")'>"+obj[i].name+"</li>"
              }
              document.getElementById("onlineUser").innerHTML = innerContent;
          }else {
              setMessageInnerHTML(content);
          }
      }

      //连接关闭的回调方法
      websocket.onclose = function () {
          setMessageInnerHTML("WebSocket连接关闭");
      }

      //监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
      window.onbeforeunload = function () {
          closeWebSocket();
      }

      //将消息显示在网页上
      function setMessageInnerHTML(innerHTML) {
          // document.getElementById('message').innerHTML += innerHTML + '<br/>';
          // 克隆结构
          var $cloneGirlGod = $('.sister').first().clone();
          // 修改内容
          $cloneGirlGod.find('p').html(innerHTML);

          // 添加到页面上
          $cloneGirlGod.appendTo('.panel-body');
          // show出来
          $cloneGirlGod.show();
      }

      //关闭WebSocket连接
      function closeWebSocket() {
          websocket.close();
      }

      //发送消息
/*      function send() {
          websocket.send(txt);
          document.getElementById('message').innerHTML += 'me:'+message + '<br/>';
      }*/

      //*************************************************************************
    $('.send').click(function () {
      // 获取输入的内容
      var inputMessage = $('.info').html();
      if(inputMessage === ""){
        alert("信息为空");
      }else {
          var txt = JSON.stringify({
              messageId: 0,
              fromName: userid,
              toName: stuId,
              messageText: inputMessage.trim(),
          })
          websocket.send(txt);
          $('.info').html("");

        // 克隆第一个 someOne
        var $cloneSome = $('.someOne').first().clone();

        // 修改内容
        $cloneSome.find('p').html(inputMessage);

        // 添加到页面上
        $cloneSome.appendTo('.panel-body');

        // show出来
        $cloneSome.show();
      }
     /* // 需求2
      //1.创建对象
      var xhr = new XMLHttpRequest();
      //2.设置请求行(get请求数据写在url后面)
      xhr.open('POST', 'http://www.tuling123.com/openapi/api');
      //3.设置请求头(get请求可以省略,post不发送数据也可以省略)
      xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
      //3.5注册回调函数
      xhr.onload = function () {
        console.log(xhr.responseText);
        // 转化为 js对象
        var result = JSON.parse(xhr.responseText);

        // 克隆结构
        var $cloneGirlGod = $('.sister').first().clone();
        // 修改内容
        $cloneGirlGod.find('p').html(result.text);

        // 添加到页面上
        $cloneGirlGod.appendTo('.panel-body');
        // show出来
        $cloneGirlGod.show();
      }
      // 参数
      xhr.send('key=e39a340d87da47829c3bee5c4df64203&info=' + inputMessage);*/
    })
//******************************************************************************************
  });
function fun(param) {
    var str = document.getElementById(param).innerText;
    window.location.href = "chat.html?stuid="+str;
    window.location.reload();
}