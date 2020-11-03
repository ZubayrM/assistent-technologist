function registration(){
  let data = $('#reg').serialize();
  $.ajax({
        method: "POST",
        url: "/regist",
        data:  data
   });

}











