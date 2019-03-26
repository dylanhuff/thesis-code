import canvas from './classes.js';
import {ctx,window,OvalObj,TextObj,RectObj,LineObj} from './classes.js';
window.renderWindow();
var text1 = new TextObj(358.0,45.0,1,'PPLineTest',"#000000", '50.0px Times New Roman');
window.addObjects([text1]);
var line2 = new LineObj(0.0,0.0,716.0,537.0,"#000000",2);
window.addObjects([line2]);
var line3 = new LineObj(0.0,537.0,716.0,0.0,"#000000",3);
window.addObjects([line3]);
var text4 = new TextObj(358.0,45.0,4,'PPRectTest',"#000000", '50.0px Times New Roman');
window.addObjects([text4]);
var rect5 = new RectObj(200,100,100,100,"#ff0000",5);
window.addObjects([rect5]);
var text6 = new TextObj(358.0,45.0,6,'PPTextBoxTest',"#000000", '50.0px Times New Roman');
window.addObjects([text6]);
var text7 = new TextObj(358.0,268.5,7,'hello, world',"#000000", '45.0px Helvetica');
window.addObjects([text7]);
function testSave(){
	document.removeEventListener('load',testSave);
	function sleep(s)
 	{return new Promise(resolve => setTimeout(resolve, s*1000));
	}
	ctx.beginPath();
	var counter = 0;
	canvas.addEventListener('click', click0);
	async function click0(){
		if (counter==0){
			counter+=1;
			canvas.addEventListener('click', click1);
	}}
	var slide1 = () => {
	window.renderObject(1);
	window.renderObject(2);
	window.renderObject(3);
	}
	slide1()
	async function click1(){
		if (counter==1){
			window.derenderAllObjects();
			window.renderOrder = [];
			slide2()
			counter+=1;
			canvas.addEventListener('click', click2);
	}}
	async function click2(){
		if (counter==2){
	window.renderObject(5);
			counter+=1;
			canvas.addEventListener('click', click3);
	}}
	var slide2 = () => {
	window.renderObject(4);
	}
	async function click3(){
		if (counter==3){
			window.derenderAllObjects();
			window.renderOrder = [];
			slide3()
			counter+=1;
			canvas.addEventListener('click', click4);
	}}
	var slide3 = () => {
	window.renderObject(6);
	window.renderObject(7);
	}
	ctx.stroke();
}
document.addEventListener('load', testSave());
