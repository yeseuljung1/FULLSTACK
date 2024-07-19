$(function () {
    var a = 0;
    setInterval(function () {
        var next = (a + 1) % 3;

        $('#slide li').eq(a).fadeOut();
        $('#slide li').eq(next).fadeIn();

        a = next;
    }, 2500);

    // ------------------------------------------------------
    $('#menu > li').mouseover(function () {
        $(this).find('.submenu').stop().slideDown(500);
    });
    $('#menu > li').mouseout(function () {
        $(this).find('.submenu').stop().slideUp(500);
    });

    // -----------------------------------------------
    $('con1 h3').click(function () {
        $('con1 h3').removeClass('on');
        $(this).addClass('on');
    });

    // -----------------------------------------------
    $('#con1 h3')
        .eq(1)
        .click(function () {
            $('#con1 ul').css('display', 'none');
            $('#gal').css('display', 'block');
        });
    $('#con1 h3')
        .eq(0)
        .click(function () {
            $('#gal').css('display', 'none');
            $('#con1 ul').css('display', 'block');
        });
    // ----------------------------------------------
    $('#con1 li')
        .eq(0)
        .click(function () {
            $('#modal ').fadeIn(500);
        });
    $('#modal div')
        .eq(0)
        .click(function () {
            $('#modal ').fadeOut(500);
        });
});
