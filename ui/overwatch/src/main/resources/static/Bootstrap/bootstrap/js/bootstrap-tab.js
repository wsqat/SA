var addTabs = function (options) {
    //可以在此处验证session
    //var rand = Math.random().toString();
    //var id = rand.substring(rand.indexOf('.') + 1);
    debugger;
    var url = window.location.protocol + '//' + window.location.host;
    options.url = url + options.url;
    id = "tab_" + options.id;
    var active_flag = false;
    if($("#" + id)){
        active_flag = $("#" + id).hasClass('active');
    }
    $(".active").removeClass("active");
    //如果TAB不存在，创建一个新的TAB
    if (!$("#" + id)[0]) {
        //固定TAB中IFRAME高度
        mainHeight = $(document.body).height();
        //创建新TAB的title
        title = '<li role="presentation" id="tab_' + id + '"><a href="#' + id + '" aria-controls="' + id + '" role="tab" data-toggle="tab"><i class="'+options.icon+'"></i>' + options.title;
        //是否允许关闭
        if (options.close) {
            title += ' <i class="glyphicon glyphicon-remove-sign" tabclose="' + id + '"></i>';
        }
        title += '</a></li>';
        //是否指定TAB内容
        if (options.content) {
            content = '<div role="tabpanel" class="tab-pane" id="' + id + '">' + options.content + '</div>';
        } else {//没有内容，使用IFRAME打开链接
            content = '<div role="tabpanel" class="tab-pane" id="' + id + '"><iframe id="iframe_'+id+'" src="' + options.url +
                '" width="100%" height="100%" onload="changeFrameHeight(this)" frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="yes" allowtransparency="yes"></iframe></div>';
        }
        //加入TABS
        $(".nav-tabs").append(title);
        $(".tab-content").append(content);
    }else{
        if(active_flag){
            $("#iframe_" + id).attr('src', $("#iframe_" + id).attr('src'));
        }
    }
    //激活TAB
    $("#tab_" + id).addClass('active');
    $("#" + id).addClass("active");
};
var changeFrameHeight = function (that) {
    $(that).height(document.documentElement.clientHeight - 115);
    $(that).parent(".tab-pane").height(document.documentElement.clientHeight - 130);
}
var closeTab = function (id) {
    //如果关闭的是当前激活的TAB，激活他的前一个TAB
    if ($("li.active").attr('id') == "tab_" + id) {
        $("#tab_" + id).prev().addClass('active');
        $("#" + id).prev().addClass('active');
    }
    //关闭TAB
    $("#tab_" + id).remove();
    $("#" + id).remove();
};
$(function () {
    $("[addtabs]").click(function () {
        addTabs({ id: $(this).attr("id"), title: $(this).attr('title'), close: true });
    });

    $(".nav-tabs").on("click", "[tabclose]", function (e) {
        id = $(this).attr("tabclose");
        closeTab(id);
    });

    window.onresize = function () {
        var target = $(".tab-content .active iframe");
        changeFrameHeight(target);
    }
});

// bootstrap-tab.js