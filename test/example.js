import canvas from './classes.js';
import {ctx,window,OvalObj,TextObj,RectObj,LineObj} from './classes.js';
window.renderWindow();
var text1 = new TextObj(358.0,45.0,1,'PPLineTest',"#000000", '50.0px Times New Roman');
window.addObjects([text1]);
var line2 = new LineObj(0.0,0.0,716.0,537.0,"#000000",2);
window.addObjects([line2]);
var line3 = new LineObj(0.0,537.0,716.0,0.0,"#000000",3);
window.addObjects([line3]);
function testSave(){
	document.removeEventListener('load',testSave);
	function sleep(s)
 	{return new Promise(resolve => setTimeout(resolve, s*1000));
	}
	ctx.beginPath();
	window.renderObject(1);
	window.renderObject(2);
	window.renderObject(3);
	ctx.stroke();
}
document.addEventListener('load', testSave());
