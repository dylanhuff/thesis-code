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
var text1 = new TextObj(358.0, 45.0, 1, 'PPRectTest', "#000000", '50.0px Times New Roman');
window.addObjects([text1]);
var rect2 = new RectObj(200, 100, 100, 100, "#ff0000", 2);
window.addObjects([rect2]);

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
			rect2.bezierMove(-100.0, 0.0, 100.0, 300.0, 300.0, 500.0, -100.0, 0.0, 1.0);
			counter += 1;
			canvas.addEventListener('click', click1);
		}
	}
	var slide1 = () => {
		window.renderObject(1);
		window.renderObject(2);
	}
	slide1()
	ctx.stroke();
}
document.addEventListener('load', testSave());