import RectObj from './classes.js';
import { canvas, ctx, GWindow } from './classes.js';
var window = new GWindow(716, 537, '1px solid');
window.renderWindow();
var rect2 = new RectObj(400, 0, 100, 100, "#000000", 2);
window.addObjects([rect2]);
var rect3 = new RectObj(100, 100, 100, 100, "#ffff00", 3);
window.addObjects([rect3]);
var rect4 = new RectObj(300, 200, 300, 100, "#0000ff", 4);
window.addObjects([rect4]);
var rect5 = new RectObj(200, 400, 100, 100, "#ff0000", 5);
window.addObjects([rect5]);
var rect6 = new RectObj(200, 100, 100, 100, "#ffc800", 6);
window.addObjects([rect6]);
var rect7 = new RectObj(400, 300, 200, 100, "#00ffff", 7);
window.addObjects([rect7]);
var rect8 = new RectObj(100, 400, 100, 200, "#ff00ff", 8);
window.addObjects([rect8]);
function testSave() {
	document.removeEventListener('load', testSave);
	function sleep(s) {
		return new Promise(resolve => setTimeout(resolve, s * 1000));
	}
	var counter = 0;
	canvas.addEventListener('click', click0);
	async function click0() {
		if (counter == 0) {
			window.renderObject(2);
			window.renderObject(3);
			counter += 1;
			canvas.addEventListener('click', click1);
		}
	}
	async function click1() {
		if (counter == 1) {
			window.renderObject(5);
			await sleep(1);
			window.renderObject(4);
			window.renderObject(7);
			await sleep(1);
			window.renderObject(6);
			counter += 1;
			canvas.addEventListener('click', click2);
		}
	}
	async function click2() {
		if (counter == 2) {
			window.renderObject(8);
			window.derenderObject(2);
			counter += 1;
			//canvas.addEventListener('click', click3);
		}
	}
	ctx.beginPath();
	ctx.ellipse(300.0, 300.0, 100.0, 50.0, 0, 0, 6.283185307179586);
	ctx.fillStyle = '#ffffff';
	ctx.fill();
	ctx.moveTo(300, 300);
	ctx.lineTo(0, 0);
	ctx.stroke();
}
document.addEventListener('load', testSave());
