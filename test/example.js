import RectObj from './classes.js';
import {canvas,ctx,window,OvalObj,TextObj} from './classes.js';
window.renderWindow();
var rect1 = new RectObj(258,168,200,200,"#000000",1);
window.addObjects([rect1]);
var oval2 = new OvalObj(175.0,175.0,100.0,100.0,0,0,6.283185307179586,"#ff0000",2);
window.addObjects([oval2]);
function testSave(){
	document.removeEventListener('load',testSave);
	function sleep(s)
 	{return new Promise(resolve => setTimeout(resolve, s*1000));
	}
	var counter = 0;
	canvas.addEventListener('click', click0);
	async function click0(){
		if (counter==0){
	window.derenderObject(1);
	counter+=1;
	canvas.addEventListener('click', click1);
	}}
	async function click1(){
		if (counter==1){
	window.renderObject(2);
	counter+=1;
	canvas.addEventListener('click', click2);
	}}
	window.renderObject(1);
	ctx.stroke();
}
document.addEventListener('load', testSave());
