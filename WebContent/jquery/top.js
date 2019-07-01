 $(window).scroll(function () {
        if ($(this).scrollTop() > 800) {
            $('.top').fadeIn();
            $('.mainmanu').css('opacity', '0.85');
        } else {
            $('.top').fadeOut();
            $('.mainmanu').css('opacity', '');
        }
    });
    $('.top').click(function () {
        $('html, body').animate({
            scrollTop: 0
        }, 500);
        return false;
    });