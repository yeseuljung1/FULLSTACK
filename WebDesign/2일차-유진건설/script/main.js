$(function(){
    var a = 0

     setInterval(function(){
         var next = (a+1)%3

        $("#slide li").eq(a).fadeOut()
        $("#slide li").eq(next).fadeIn()

        a=next
    },2500)

/* --------------서브메뉴--------------------------- */
    $("#menu > li").mouseover(function(){
        $(".submenu , #menubg").stop().slideDown(500)
    })

    $("#menu > li").mouseout(function(){
        $(".submenu , #menubg").stop().slideUp(500)
    })

// ------------------------레이어팝업창---------------------------
    $("#con1 li").eq(0).click(function(){
        $("#modal").fadeIn(500)
    })
    $("#modal div").click(function(){
        $("#modal").fadeOut(500)
    })
})