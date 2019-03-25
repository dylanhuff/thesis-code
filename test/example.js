import canvas from './classes.js';
import {ctx,window,OvalObj,TextObj,RectObj} from './classes.js';
window.renderWindow();
var text1 = new TextObj(358.0,45.0,1,'PPLineTest',"#000000", '50.0px Times New Roman');
window.addObjects([text1]);
function testSave(){
	document.removeEventListener('load',testSave);
	function sleep(s)
 	{return new Promise(resolve => setTimeout(resolve, s*1000));
	}
	window.renderObject(1);
	ctx.stroke();
}
document.addEventListener('load', testSave());
