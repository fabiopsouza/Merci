$(document).ready(function(){
	$("#searchInput").keydown(function() {
		
		var selectedPage = getSelectedPage() - 1;
		var lineNumbers = $('#lineNumbers').val();
		var name = $('#searchInput').val();
		
		console.log(getRootPath() + 'cidade/' + selectedPage + '/' + lineNumbers + '/' + name);
		
		$(location).attr("href", getRootPath() + 'cidade/' + selectedPage + '/' + lineNumbers + '/' + name);
		
		//redirect('cidade/' + selectedPage + '/' + lineNumbers + '/' + name);
	});
})

function getSelectedPage(){
	return $("#paginationGrid").find('.active').find('a').text();
}