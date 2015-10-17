 $("#login-button").click(function(event){

 		window.open("../ListViews/index.html");
		 event.preventDefault();
	 	$('form').fadeOut(500);
	 	$('.wrapper').addClass('form-success');
	 }
);