$(document).ready(function(){
    $("#submit").click(function(){
    	var name=$("#username").val();
    	var psd=$("#password").val();
    	var userJson={username:name,password:psd};
    	//alert(name+" "+psd);
    	$.ajax({
    		url:"http://localhost:8080/guser/user/login",
    		type:"post",
    		data:userJson,
    		success:function(data){
    			if(data != "")
    				location.href ="http://localhost:8080/gblog/imagecate";
    			else
    				alert("用户名或密码错误！");
    		},
    		complete:function(){}
    	});
    });
});