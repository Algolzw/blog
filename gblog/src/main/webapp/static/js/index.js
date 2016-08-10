$(document).on("ready", function () {

    $(".cate-block").each(function () {
        var path = $(this).find("img").eq(0).attr("src");
        $(this).bind({
            "mouseenter": function () {
                // $(".content-wapper").css("background","url("+path+")
                // top").stop().delay(90).animate({backgroundPositionY:'+20px'},400);
                $(this).find(".info-wapper").eq(0).stop().show(1000);
            },
            "mouseleave": function () {
                $(this).find(".info-wapper").eq(0).stop().hide(1000);
            }
        });
    });

    $("#nav-top ul:eq(0)>li:eq(0)").addClass('active');

    //设置界面元素高度

    resizeIndex();

    window.onresize = function () {
        resizeIndex();
    }
    function resizeIndex(){
        $(".nav-layer.navbar-fixed-top").height($("#nav-top").height());
        $("#myCarousel .item").height($(window).height() - $('#nav-top').height() * 2);

        //$("section").height($(window).height() - $("#nav-top").height() * 2);
        var bucket_imgheight = $(window).height() - $(".slogan:eq(0)").height() * 2;
        if(bucket_imgheight<270){
            bucket_imgheight = 270;
        }
        $(".fromone-bucket .row .imgLiquid").height(bucket_imgheight);

        var inspiration_imgheight = $(window).height() - $(".slogan:eq(1) article").height() * 2;
        if(inspiration_imgheight<486){
            inspiration_imgheight = 486;
        }
        $("section .inspiration").height(inspiration_imgheight);

    }

    $(".ei_imgLiquid").imgLiquid({
        fill: true,
        horizontalAlign: "center",
        verticalAlign: "80%"
    });

    $(".imgLiquid").imgLiquid();


    $(".photo-wall-main").justifiedGallery({
        rowHeight:210,
        lastRow:'nojustify',
        margins:5,
        sizeRangeSuffixes:{
            100 : '_t', // used with images which are less than 100px on the longest side
            240 : '_m', // used with images which are between 100px and 240px on the longest side
            320 : '_n', // ...
            500 : '',
            640 : '_z',
            1024 : '_b'
        }
    });

});
