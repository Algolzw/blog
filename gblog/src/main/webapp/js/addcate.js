$(document).on('ready',function(){
	$("#file-input").fileinput({
        previewFileType: "image",
        browseClass: "btn btn-success",
        browseLabel: "选择图片",
        browseIcon: "<i class=\"glyphicon glyphicon-picture\"></i> ",
        removeClass: "btn btn-danger",
        removeLabel: "Delete",
        removeIcon: "<i class=\"glyphicon glyphicon-trash\"></i> ",
        uploadClass: "btn btn-info",
        uploadLabel: "Upload",
        uploadIcon: "<i class=\"glyphicon glyphicon-upload\"></i> "
	});
	
});