chrome.runtime.onMessage.addListener(function(request) {
  if(request.action == "executeCode") {
    $("#inventoryText").val(request.data);
    $("#inventoryBtn").click();
    $("#inventoryText").val("");
  }
});

//$("#inventoryText").css("background-color", "yellow");