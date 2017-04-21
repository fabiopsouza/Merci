function getRootPath(){
	return window.location.host + '/'
}

function redirect(path){
	$(location).attr("href", getRootPath() + path);
}