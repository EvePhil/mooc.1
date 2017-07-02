/**
 * Created by lynn on 2017/7/1.
 */
$(function () {

    var url = {
        tmapp: "/api/tc-getG",
        tminfo: "/api/tc-getAcc",
        tmdel: "/api/tc-delG",
        uploadsrc: "/api/tc-up-src"
    };

    $('.hw-del').click(function () {
        $("[name='checkbox']").each(function () {
            if ($(this).prop('checked')) {
                $(this).parents('li').css('display', 'none');
            }
        });
    });
    $('.hw-public').on('click', function () {
        var header = $('#hwheadline').val();
        var content = $('#hwcontent').val();
        if (header && content) {
            var headerhtml = '<li> <div class="collapsible-header"> <div class="col s1 m1 selectDown"> <form> <p> <input type="checkbox" name="checkbox" class="filled-in" id="hw4"> <label for="hw4"></label> </p> </form> </div> <i class="material-icons">filter_drama</i>';
            var middlehtml = '<i class="material-icons text-black right">play_for_work</i> </div> <div class="collapsible-body"> <span>';
            var footerhtml = '</span> </div> </li>';

            $('.show-tw').append(headerhtml + header + middlehtml + content + footerhtml);

        } else {
            Materialize.toast('请输入完整的标题和说明文字', 4000);
        }
    });

})

