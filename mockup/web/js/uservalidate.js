//关于数字和字母的验证并未完成
function validate(){
   
    //验证用户名是否合法
	 
	 
	
	var vil=true;
	if(userName.value.length==0)
	{
		
		b1.innerHTML="用户名不能为空";
		userName.focus();
		
		
		vil=false;
	}
	else if(userName.value.length>8){
		b1.innerHTML="用户名的长度不能超过8位";
		userName.focus();
		vil=false;
	}else
	{
		//在用户再次提交表单时，如果合法，取消前一次的验证不合法消息
		b1.innerHTML="";
	}
	//验证密码输入是否合法

			
	if(password.value.length==0)
	{
		b2.innerHTML="密码不能为空";
	
		password.focus();
		

		vil=false;
	}
	else if(password.value.length<4||password.value.length>8)
	{
		b2.innerHTML="密码的长度应该介于4到8位之间";
		password.focus();
		vil=false;
	}else
	{
		b2.innerHTML="";
	}
	//验证确认密码的输入是否合法
	
	if(password2.value.length==0)
	{
		b3.innerHTML="确认密码不能为空";
		password2.focus();
		vil=false;
	}
	else if(password2.value!=password.value)
	{
		b3.innerHTML="确认密码和密码不一致,请确认";
		password2.focus();
		vil=false;
	}else
	{
		b3.innerHTML="";
	}
	//验证Email的输入是否合法
	 
	if(email.value.length!=0)
	{
		var emailvalue=email.value;
		//验证邮件地址中有且仅有一个.和一个@
		if(emailvalue.indexOf(".")==-1||emailvalue.indexOf(".")!=emailvalue.lastIndexOf(".")||emailvalue.indexOf("@")==-1||emailvalue.indexOf("@")!

=emailvalue.lastIndexOf("@"))
		{
			b4.innerHTML="邮件地址不合法";
			email.focus();
			vil=false;
		}
		//验证.和@的位置,@不能出现在第一个,.不能出现在最后一个,并且@必须出现在.前面,中间必须至少有一个字符
		else if(emailvalue.indexOf("@")==0||emailvalue.indexOf(".")==emailvalue.length-1||emailvalue.indexOf(".")-emailvalue.indexOf("@")<2)
		{
			b4.innerHTML="邮件地址不合法";
			email.focus();
			vil=false;
		}else{
			b4.innerHTML="";
		}
	}
	
	return vil;
}