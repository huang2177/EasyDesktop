function callJS(){
        var btnVal=document.getElementById("text");
        if(btnVal.value=="下一步"){
            btnVal.value="处理中…";
        }else{
            btnVal.value="已完成！！！;
        }
        return "Hello,World!!!!!";
   }