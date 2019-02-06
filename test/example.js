import RectObj from './classes.js';
import {canvas,ctx,window,OvalObj,TextObj} from './classes.js';
window.renderWindow();
var text1 = new TextObj(358.0,45.0,1,'Simple Shapes',"#000000", '50.0px Times New Roman');
window.addObjects([text1]);
var rect2 = new RectObj(258,168,200,200,"#ff0000",2);
window.addObjects([rect2]);
var oval3 = new OvalObj(358.0,268.5,100.0,100.0,0,0,6.283185307179586,"#00ff00",3);
window.addObjects([oval3]);
function testSave(){
	document.removeEventListener('load',testSave);
	function sleep(s)
 	{return new Promise(resolve => setTimeout(resolve, s*1000));
	}
	var counter = 0;
	canvas.addEventListener('click', click0);
	async function click0(){
		if (counter==0){
	window.renderObject(3);
	counter+=1;
	canvas.addEventListener('click', click1);
	}}
	async function click1(){
		if (counter==1){
	window.derenderObject(2);
	counter+=1;
	canvas.addEventListener('click', click2);
	}}
	window.renderObject(1);
	window.renderObject(2);
	ctx.stroke();
}
document.addEventListener('load', testSave());
