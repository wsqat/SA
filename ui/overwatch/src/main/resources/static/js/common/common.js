
//override dialog's title function to allow for HTML titles
$.widget("ui.dialog", $.extend({}, $.ui.dialog.prototype, {
	_title: function(title) {
		var $title = this.options.title || '&nbsp;'
		if( ("title_html" in this.options) && this.options.title_html == true )
			title.html($title);
		else title.text($title);
	}
}));

function logoff() {
	//this.preventDefault();
	
	var dialog = $( "#dialog-message" ).removeClass('hide').dialog({
		modal: true,
		title: "<div class='widget-header widget-header-small'><h4 class='smaller'><i class='icon-ok'></i> 确定要退出吗?</h4></div>",
		title_html: true,
		buttons: [ 
			{
				text: "Cancel",
				"class" : "btn btn-xs",
				click: function() {
					$( this ).dialog( "close" ); 
				} 
			},
			{
				text: "OK",
				"class" : "btn btn-primary btn-xs",
				click: function() {
					$( this ).dialog( "close" ); 
				} 
			}
		]
	});
}