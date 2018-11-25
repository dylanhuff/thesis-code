var canvas = document.createElement('canvas');
var ctx = canvas.getContext('2d');
function RectObj(x, y, height, width, color) {
	this.x = x;
	this.y = y;
	this.width = width;
	this.height = height;
	this.color = color;
}
RectObj.prototype.renderRect = function (that) {
	ctx.rect(this.x, this.y, this.height, this.width);
	ctx.fillStyle = this.color;
	ctx.fillRect(this.x, this.y, this.height, this.width);
}
RectObj.prototype.clearRect = function (that) {
	ctx.clearRect(this.x, this.y, this.height, this.width);
}

rect2 = new RectObj(400, 0, 100, 100, "#000000");
rect3 = new RectObj(100, 100, 100, 100, "#ffff00");
rect4 = new RectObj(300, 200, 300, 100, "#0000ff");
rect5 = new RectObj(200, 400, 100, 100, "#ff0000");
rect6 = new RectObj(200, 100, 100, 100, "#ffc800");
rect7 = new RectObj(400, 300, 200, 100, "#00ffff");
rect8 = new RectObj(100, 400, 100, 200, "#ff00ff");
function testSave() {
	canvas.width = '716';
	canvas.height = '537';
	canvas.style.border = '1px solid';
	var body = document.getElementsByTagName('body')[0];
	body.appendChild(canvas);
	function sleep(s) {
		return new Promise(resolve => setTimeout(resolve, s * 1000));
	}
	var counter = 0;
	canvas.addEventListener('click', click0);
	async function click0() {
		if (counter == 0) {
			rect2.renderRect();
			rect3.renderRect();
			counter += 1;
			canvas.addEventListener('click', click1);
		}
	}
	async function click1() {
		if (counter == 1) {
			rect5.renderRect();
			await sleep(2);
			rect4.renderRect();
			rect7.renderRect();
			await sleep(4);
			rect6.renderRect();
			counter += 1;
			canvas.addEventListener('click', click2);
		}
	}
	async function click2() {
		if (counter == 2) {
			rect8.renderRect();
			counter += 1;
			canvas.addEventListener('click', click3);
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