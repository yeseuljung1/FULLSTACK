$(function(){
    var a = 0
    /* 가만히 있어도 무한재생 jq->(setInterval) */
    setInterval(function(){
        var next = (a+1)%3

        $("#slide li").eq(a).fadeOut()/* (fadeout 말고 위에서 아래 또는 좌에서 우도 있음/총3가지) */
        $("#slide li").eq(next).fadeIn()

        a = next/* (오른쪽에 있는 변수가 덮어씀/next가 1이라서 a=1이됨) */
    },2500)

/* ----------------------메뉴----------------------------------- */
    $("#menu > li"). mouseover(function(){
        $(this).find(".submenu").stop().slideDown(500) /* (mouseover/out은 stop이 없으면 버그걸려서 필요함) */
    })

    $("#menu > li"). mouseout(function(){
        $(this).find(".submenu").stop().slideUp(500)
    })
/* ------------------공지사항/갤러리------------------------------------------ */
    $("#con1 h3").click(function(){
        $("#con1 h3").removeClass("on")
        $(this).addClass("on")
    })
/* ------------------팝업창------------------------------------------ */
    $("#con1 li").eq(0).click(function(){
        $("#modal").fadeIn(500)
    })
    $("#modal div").click(function(){
        $("#modal").fadeOut(500)
    })
/* ------------------갤러리선택시------------------------------------------ */
    $("#con1 h3").eq(1).click(function(){
        $("#con1 ul").css("display","none")
        $("#gal").css("display","block")
    })
    $("#con1 h3").eq(0).click(function(){
        $("#gal").css("display","none")
        $("#con1 ul").css("display","block")
    })


})