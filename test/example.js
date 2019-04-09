import canvas from './classes.js';
import {
	ctx,
	window,
	OvalObj,
	TextObj,
	RectObj,
	LineObj
} from './classes.js';
window.renderWindow();
var text1 = new TextObj(358.0, 45.0, 1, 'Simple Shapes', "#000000", '50.0px Times New Roman');
window.addObjects([text1]);
var rect2 = new RectObj(258, 168, 200, 200, "#ff0000", 2);
window.addObjects([rect2]);
var oval3 = new OvalObj(175.0, 175.0, 100.0, 100.0, 0, 0, 6.283185307179586, "#ff0000", 3);
window.addObjects([oval3]);
var text4 = new TextObj(358.0, 45.0, 4, 'PPLineTest', "#000000", '50.0px Times New Roman');
window.addObjects([text4]);
var line5 = new LineObj(0.0, 0.0, 716.0, 537.0, "#000000", 5);
window.addObjects([line5]);
var line6 = new LineObj(0.0, 537.0, 716.0, 0.0, "#000000", 6);
window.addObjects([line6]);
var text7 = new TextObj(358.0, 45.0, 7, 'PPRectTest', "#000000", '50.0px Times New Roman');
window.addObjects([text7]);
var rect8 = new RectObj(200, 100, 100, 100, "#ff0000", 8);
window.addObjects([rect8]);
var text9 = new TextObj(358.0, 45.0, 9, 'PPOvalTest', "#000000", '50.0px Times New Roman');
window.addObjects([text9]);
var oval10 = new OvalObj(358.0, 268.5, 50.0, 50.0, 0, 0, 6.283185307179586, "#000000", 10);
window.addObjects([oval10]);
var text11 = new TextObj(358.0, 45.0, 11, 'PPTextBoxTest', "#000000", '50.0px Times New Roman');
window.addObjects([text11]);
var text12 = new TextObj(358.0, 268.5, 12, 'hello, world', "#000000", '45.0px Helvetica');
window.addObjects([text12]);
var text13 = new TextObj(358.0, 45.0, 13, 'Testing yo', "#000000", '50.0px Times New Roman');
window.addObjects([text13]);
var oval21 = new OvalObj(400.0, 350.0, 100.0, 50.0, 0, 0, 6.283185307179586, "#ffffff", 21);
window.addObjects([oval21]);
var rect14 = new RectObj(400, 0, 100, 100, "#000000", 14);
window.addObjects([rect14]);
var rect15 = new RectObj(100, 100, 100, 100, "#ffff00", 15);
window.addObjects([rect15]);
var rect16 = new RectObj(300, 200, 300, 100, "#0000ff", 16);
window.addObjects([rect16]);
var rect17 = new RectObj(200, 400, 100, 100, "#ff0000", 17);
window.addObjects([rect17]);
var rect18 = new RectObj(200, 100, 100, 100, "#ffc800", 18);
window.addObjects([rect18]);
var rect19 = new RectObj(400, 300, 200, 100, "#00ffff", 19);
window.addObjects([rect19]);
var rect20 = new RectObj(100, 400, 100, 200, "#ff00ff", 20);
window.addObjects([rect20]);
var line22 = new LineObj(0.0, 0.0, 300.0, 300.0, "#000000", 22);
window.addObjects([line22]);

function testSave() {
	document.removeEventListener('load', testSave);

	function sleep(s) {
		return new Promise(resolve => setTimeout(resolve, s * 1000));
	}

	function scale() {
		var viewHeight = document.documentElement.clientHeight - 20;
		var viewWidth = document.documentElement.clientWidth - 20;
		var scaleHeight = viewHeight / window.height;
		var scaleWidth = viewWidth / window.width;
		var scaleFactor;
		((scaleWidth < scaleHeight) ? scaleFactor = scaleWidth : scaleFactor = scaleHeight)
		window.height *= scaleFactor;
		window.width *= scaleFactor;
		window.renderWindow()
		ctx.scale(scaleFactor, scaleFactor)
	}
	scale();
	ctx.beginPath();
	var counter = 0;
	canvas.addEventListener('click', click0);
	async function click0() {
		if (counter == 0) {
			window.derenderObject(2);
			counter += 1;
			canvas.addEventListener('click', click1);
		}
	}
	async function click1() {
		if (counter == 1) {
			window.renderObject(3);
			counter += 1;
			canvas.addEventListener('click', click2);
		}
	}
	var slide1 = () => {
		window.renderObject(1);
		window.renderObject(2);
	}
	slide1()
	async function click2() {
		if (counter == 2) {
			window.derenderAllObjects();
			window.renderOrder = [];
			slide2()
			counter += 1;
			canvas.addEventListener('click', click3);
		}
	}
	var slide2 = () => {
		window.renderObject(4);
		window.renderObject(5);
		window.renderObject(6);
	}
	async function click3() {
		if (counter == 3) {
			window.derenderAllObjects();
			window.renderOrder = [];
			slide3()
			counter += 1;
			canvas.addEventListener('click', click4);
		}
	}
	var slide3 = () => {
		window.renderObject(7);
		window.renderObject(8);
	}
	async function click4() {
		if (counter == 4) {
			window.derenderAllObjects();
			window.renderOrder = [];
			slide4()
			counter += 1;
			canvas.addEventListener('click', click5);
		}
	}
	var slide4 = () => {
		window.renderObject(9);
		window.renderObject(10);
	}
	async function click5() {
		if (counter == 5) {
			window.derenderAllObjects();
			window.renderOrder = [];
			slide5()
			counter += 1;
			canvas.addEventListener('click', click6);
		}
	}
	var slide5 = () => {
		window.renderObject(11);
		window.renderObject(12);
	}
	async function click6() {
		if (counter == 6) {
			window.derenderAllObjects();
			window.renderOrder = [];
			slide6()
			counter += 1;
			canvas.addEventListener('click', click7);
		}
	}
	async function click7() {
		if (counter == 7) {
			window.renderObject(14);
			window.renderObject(15);
			counter += 1;
			canvas.addEventListener('click', click8);
		}
	}
	async function click8() {
		if (counter == 8) {
			window.renderObject(17);
			await sleep(1);
			window.renderObject(16);
			window.renderObject(19);
			await sleep(1);
			window.renderObject(18);
			counter += 1;
			canvas.addEventListener('click', click9);
		}
	}
	async function click9() {
		if (counter == 9) {
			window.renderObject(20);
			rect15.move(600.0, 200.0, 5.0990195135927845);
			counter += 1;
			canvas.addEventListener('click', click10);
		}
	}
	var slide6 = () => {
		window.renderObject(13);
		window.renderObject(21);
		window.renderObject(22);
	}
	ctx.stroke();
}
document.addEventListener('load', testSave());