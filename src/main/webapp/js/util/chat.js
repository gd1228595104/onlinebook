$(function () {
    // $.extend({
    //     getUrlParam(name){
    //         var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    //         var r = window.location.search.substr(1).match(reg);
    //         if (r != null) return unescape(r[2]); return null;
    //     }
    // })
    //获取发送人信息
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
    var websocket = null;
    /*
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
        setMessageInnerHTML(event.data);

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
    }

    //关闭WebSocket连接
    function closeWebSocket() {
        websocket.close();
    }

    //发送消息
    function send() {
        var message = document.getElementById('text').value;
        var txt = JSON.stringify({
            messageId:0,
            fromName:document.getElementById('From').innerHTML,
            toName:document.getElementById('To').value,
            messageText:message,
        })
        websocket.send(txt);
        document.getElementById('message').innerHTML += 'me:'+message + '<br/>';
    }
*/
})