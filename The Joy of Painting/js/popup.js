document.addEventListener('DOMContentLoaded', function () {

  $("#union_param_2").hide();
  $("#union_param_3").hide();
  $("#union_param_4").hide();
  $("#union_param_5").hide();


  $("#test_btn").on("click", function () {
    chrome.tabs.query({
      active: true,
      currentWindow: true
    }, function (activeTabs) {
      chrome.tabs.sendMessage(activeTabs[0].id, {
        action: "executeCode"
      });
    });

    $("#injection_string").html("' UNION (SELECT TABLE_NAME, TABLE_SCHEMA FROM information_schema.tables); -- ")

    //$("body").append("<p>Hello</p>");
    //$("#inventoryBtn").click();
    //$("#inventoryText").val("' UNION (SELECT TABLE_NAME, TABLE_SCHEMA FROM information_schema.tables); -- ");
  });


  $("#union_column_selector").change(function () {
    switch ($("#union_column_selector").val()) {
      case "1":
        $("#union_param_1").show();
        $("#union_param_2").hide();
        $("#union_param_3").hide();
        $("#union_param_4").hide();
        $("#union_param_5").hide();
        break;
      case "2":
        $("#union_param_1").show();
        $("#union_param_2").show();
        $("#union_param_3").hide();
        $("#union_param_4").hide();
        $("#union_param_5").hide();
        break;
      case "3":
        $("#union_param_1").show();
        $("#union_param_2").show();
        $("#union_param_3").show();
        $("#union_param_4").hide();
        $("#union_param_5").hide();
        break;
      case "4":
        $("#union_param_1").show();
        $("#union_param_2").show();
        $("#union_param_3").show();
        $("#union_param_4").show();
        $("#union_param_5").hide();
        break;
      case "5":
        $("#union_param_1").show();
        $("#union_param_2").show();
        $("#union_param_3").show();
        $("#union_param_4").show();
        $("#union_param_5").show();
        break;
      default:
    }
  })



  $("#page_1").on("click", function () {
    $("#form_container").html("\
      <div class='form-group'>\
        <h6>TAUTOLOGY</h6>\
        <label for='param_1'>Query:</label>\
        <input class='form-control' name='union_param_1'>\
      </div>\
    ");
  });



})