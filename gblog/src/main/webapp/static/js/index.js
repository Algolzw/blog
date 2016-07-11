/**
 * 2016 4.7
 */

$(document).on("ready", function() {
	$(".cate-block").each(function() {
		var path = $(this).find("img").eq(0).attr("src");
		$(this).bind({
			"mouseenter" : function() {
				// $(".content-wapper").css("background","url("+path+")
				// top").stop().delay(90).animate({backgroundPositionY:'+20px'},400);
				$(this).find(".info-wapper").eq(0).stop().show(1000);
			},
			"mouseleave" : function() {
				$(this).find(".info-wapper").eq(0).stop().hide(1000);
			}
		});
	});

	
	
	
	
});
