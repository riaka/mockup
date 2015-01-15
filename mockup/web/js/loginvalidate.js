function loginvalidate(){
	var vil=true;
	if(userName.value.length==0)
	{
		userName.focus();
		p1.innerHTML="用户名不能为空";		
		vil=false;
	}
	else if(userName.value.length>8){
		
		userName.focus();
		p1.innerHTML="用户名的长度不能超过8位";
		vil=false;
	}else
	{
		
		p1.innerHTML="";
	}

	//验证密码输入是否合法
	 
	if(password.value.length==0)
	{
		p2.innerHTML="密码不能为空";
		password.focus();
		vil=false;
	}
	else if(password.value.length<4||password.value.length>8)
	{
		p2.innerHTML="密码的长度应该介于4到8位之间";
		password.focus();
		vil=false;
	}else
	{
		p2.innerHTML="";
	}
	 
	return vil;
}