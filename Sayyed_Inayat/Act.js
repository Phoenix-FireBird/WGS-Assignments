function retrive() {
    var actid= document.getElementById('in1');
    var actname= document.getElementById('in2');
    var actAdd=document.getElementById('a');
    var birth= document.getElementById('dobin');
    var genAns= document.getElementById('r1');
    var genAn2= document.getElementById('r2');


    var actType1=document.getElementById('ch1');
    var actType2=document.getElementById('ch2');

    var actType3=document.getElementById('ch3');
    var actType4=document.getElementById('ch4');

    var obj={ActId:actid.value,
            ActName:actname.value,
            ActAdd:actAdd.value,
            DoB:birth.value,
            Gender:{M:genAns.value,F:genAn2.value},
            ActType:{
                t1:actType1.value,
                t2:actType2.value,
                t3:actType3.value,
                t4:actType4.value

            }
    }

console.log(obj);
    
}


function Add() {
    var actid= document.getElementById('in1');
    var actname= document.getElementById('in2');
    var actAdd=document.getElementById('a');
    var birth= document.getElementById('dobin');
    var gen= va();
    var type=chk();
    var table = document.getElementById("myTable");
    var row = table.insertRow(1);
    var cell1 = row.insertCell(0);
    var cell2 = row.insertCell(1);
    var cell3 = row.insertCell(2);
    var cell4 = row.insertCell(3);
    var cell5= row.insertCell(4);
    var cell6= row.insertCell(5);



    cell1.innerHTML =actid.value ;
    cell2.innerHTML =actname.value ;
    cell3.innerHTML =actAdd.value ;
    cell4.innerHTML =birth.value ;
    cell5.innerHTML=gen;
    cell6.innerHTML=type;

    // alert("Details Submitted 😊");
}




function dlete() {
    var table = document.getElementById("myTable");
    table.deleteRow(1);
    // alert("Details Removed 😊");
    
}



 

function va() {
    var  rad = document.getElementsByName('Gender');
    for (var radio of rad)
    {
        if (radio.checked) {
            return radio.value;
        }
    }
}


function update() {
    var actid= document.getElementById('in1').value;
    var actname= document.getElementById('in2').value;
    var actAdd=document.getElementById('a').value;
    var birth= document.getElementById('dobin').value;
    var gen= va();
    var type=chk();
    var table = document.getElementById("myTable");
    table.rows[1].cells[0].innerHTML=actid;
    table.rows[1].cells[1].innerHTML=actname;
    table.rows[1].cells[2].innerHTML=actAdd;
    table.rows[1].cells[3].innerHTML=birth;
    table.rows[1].cells[4].innerHTML=gen;
    table.rows[1].cells[5].innerHTML=type;
}

function chk() {
  var str =''

  var boxvalues = document.getElementsByName('chek');
for (var box of boxvalues)
{
    if (box.checked) {
        str =box.value + ' ' + str;
    }
}
 return str;
}


//     var y1 = document.getElementById("ch1");  
//   var y2 = document.getElementById("ch2");  
//   var y3 = document.getElementById("ch3");  

//   var y4 = document.getElementById("ch4");  
// //  var obj=[y1,y2,y3,y4];
// //  console.log(y1.value);
//   if (y1.checked == true){  
//         return "SB";
//       }  
//       else if (y2.checked == true){  
//         return "FD";
//       } 
//       else if (y3.checked == true){  
//         return "CB";
//       } 
//       else if (y4.checked == true){  
//         return "LOAN";
//       } 
//  for (let i = 0; i < obj.length; i++) {
     
//     if (obj[i].checked == true){  
//         var y= document.getElementById("ch1").value; 
//         // return y;
//         console.log(y);
//       }  
    //   else if (obj[i].checked == true){  
    //     return "FD";
    //   } 
    //   else if (obj[i].checked == true){  
    //     return "CB";
    //   } 
    //   else if (obj[i].checked == true){  
    //     return "LOAN";
    //   } 
//  }
// }






// if (y1.checked == true){  
//     return "SB";
//   }  
//   else if (y2.checked == true){  
//     return "FD";
//   } 
//   else if (y3.checked == true){  
//     return "CB";
//   } 
//   else if (y4.checked == true){  
//     return "LOAN";
//   } 