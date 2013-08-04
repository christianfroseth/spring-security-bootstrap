(function () {
    if (window.location.href.indexOf("failed") != -1) {
        $("#login_message").toggle();
    }

    if (window.location.href.indexOf("logout") != -1) {
        $("#logout_message").toggle();
    }
})();

