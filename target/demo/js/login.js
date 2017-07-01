$("#log").click(function(){
	var user = {'Id': $(".userName").val(), 'password': $(".userPsd").val()};
	$.post('/mooc/loginCheck',user,function (result) {
		//alert(result);
		if(result == "no")
		{
			alert("用户名不存在！");
			$(".userName").focus();
		}
		else if(result == "wrong")
		{
			alert("密码错误！");
			$(".userPsd").focus();
		}
		else if(result == "jiaowu")
		{
			alert("教务登录成功！");
		}
		else if(result == "teacher")
		{
			alert("教师登录成功！");
		}
		else if(result == "student")
		{
			alert("学生登录成功！");
			window.location.href="http://localhost:8080/mooc/index";
		}
    })
	/*if($(".name").val() == "") {
		alert("用户名为空！")
		$(".name").focus();
		return false;
	}
	if($(".password").val() == 0) {
		alert("密码为空！")
		$(".password").focus();
		return false;
	}
	
	var users = "<%= users%>";
	var passwords = "<%= passwords%>";
	var x;
	var name;
	var password;
	var flag1 = 0;
	var flag2 = 0;
	var result1 = users.split(",");
	var result2 = passwords.split(",");
	for(var i = 0; i < result1.length; i++){	
		if(i == 0){
			name = result1[i].replace("[","");
		}
		else if(i ==  result1.length-1){
			name = result1[i].replace("]","");
			name = name.replace(" ","");
		}
		else {
			name = result1[i].replace(" ","");
		}
		if($(".name").val() == name) {
			x = i;
			flag1 = 1;
		}
	}
	if(flag1 == 0) {
		alert("用户名不存在！")
		$(".name").focus();
		return false;
	}
	
	if(x == 0){
		password = result2[x].replace("[","");
	}
	else if(x == result2.length - 1){
		password = result2[x].replace("]","");
		password = password.replace(" ","");
	}
	else {
		password = result2[x].replace(" ","");
	}
	if($(".password").val() == password) {
		flag2 = 1;
	}
	if(flag2 == 0) {
		alert("密码错误！")
		$(".password").focus();
		return false;
	}
	if((flag1 == 1)||(flag2 == 1)) {
		alert("登录成功！");
		$("#login").submit();
	}*/
		
});
