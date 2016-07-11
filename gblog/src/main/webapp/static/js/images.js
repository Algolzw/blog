/**
 * 
 */

$(document).on("ready", function() {
	$("img.img-item").each(function() {
		$(this).bind({
			"mouseenter" : function() {
				$(this).next(".layer").bind("mouseleave", function() {
					$(this).stop().fadeOut(500);
				}).stop().fadeIn(300);
			}
		});
	});
});

function toggleShow(str) {

}