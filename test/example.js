import canvas from './classes.js';
import {ctx,window,OvalObj,TextObj,RectObj,LineObj} from './classes.js';
window.renderWindow();
var text1 = new TextObj(358.0,45.0,1,'Selection Sorting',"#000000", '50.0px Times New Roman');
window.addObjects([text1]);
var text2 = new TextObj(298.0,150.0,2,'5',"#000000", '30.0px Times New Roman');
window.addObjects([text2]);
var text3 = new TextObj(328.0,150.0,3,'4',"#000000", '30.0px Times New Roman');
window.addObjects([text3]);
var text4 = new TextObj(358.0,150.0,4,'3',"#000000", '30.0px Times New Roman');
window.addObjects([text4]);
var text5 = new TextObj(388.0,150.0,5,'2',"#000000", '30.0px Times New Roman');
window.addObjects([text5]);
var text6 = new TextObj(418.0,150.0,6,'1',"#000000", '30.0px Times New Roman');
window.addObjects([text6]);
function testSave(){
	document.removeEventListener('load',testSave);
	function sleep(s)
 	{return new Promise(resolve => setTimeout(resolve, s*1000));
	}
	function scale(){
		var viewHeight = document.documentElement.clientHeight-20;
		var viewWidth = document.documentElement.clientWidth-20;
		var scaleHeight = viewHeight / window.height;
		var scaleWidth = viewWidth / window.width;
		var scaleFactor;
		((scaleWidth<scaleHeight) ? scaleFactor = scaleWidth : scaleFactor = scaleHeight)
		window.height *= scaleFactor;
		window.width *= scaleFactor;
		window.renderWindow()
		ctx.scale(scaleFactor,scaleFactor)
	}
	scale();
	ctx.beginPath();
	var counter = 0;
	canvas.addEventListener('click', click0);
	async function click0(){
		if (counter==0){
	text6.move(298.0,150.0,1.2);
	text2.move(328.0,150.0,0.3);
	text3.move(358.0,150.0,0.3);
	text4.move(388.0,150.0,0.3);
	text5.move(418.0,150.0,0.3);
			counter+=1;
			canvas.addEventListener('click', click1);
	}}
	var slide1 = () => {
	window.renderObject(1);
	window.renderObject(2);
	window.renderObject(3);
	window.renderObject(4);
	window.renderObject(5);
	window.renderObject(6);
	}
	slide1()
	ctx.stroke();
}
document.addEventListener('load', testSave());
