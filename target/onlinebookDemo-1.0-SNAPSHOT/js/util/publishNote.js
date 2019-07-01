layui.use('layer',function(){
    $(document).ready(function () {
        $("#publishNotic").on('click', function () {
            var content = $("#noticContent").val();
            $.ajax({
                url: "PublishAnnouncement.action",
                method: "GET",
                async: false,
                data: {
                    announcement: content
                },
                success: function (data) {
                    var result = data.data;
                    layer.alert(result);
                }

            })
        })
    })
})
