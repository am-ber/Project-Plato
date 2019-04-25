document.addEventListener('DOMContentLoaded', function() {

  
  $("#test_btn").on("click", function() {
    chrome.tabs.query({ active: true, currentWindow: true }, function(activeTabs) {
      chrome.tabs.sendMessage(activeTabs[0].id, { action: "executeCode" });
    });

    //$("body").append("<p>Hello</p>");
    //$("#inventoryBtn").click();
    //$("#inventoryText").val("' UNION (SELECT TABLE_NAME, TABLE_SCHEMA FROM information_schema.tables); -- ");
  });
  
  
  
  /*
  var this_id = document.getElementById("inventoryText");
  this_id.val = "Test";
  */

})