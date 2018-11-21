function testSave() {
	var canvas = document.createElement('canvas');
	canvas.width = '716';
	canvas.height = '537';
	canvas.style.border = '1px solid';
	var body = document.getElementsByTagName('body')[0];
	body.appendChild(canvas);
	var ctx = canvas.getContext('2d');
	function sleep(s) {
		return new Promise(resolve => setTimeout(resolve, s * 1000));
	}
	var counter = 0;
	canvas.addEventListener('click', click0);
	async function click0() {
		if (counter == 0) {
			ctx.rect(400, 0, 100, 100);
			ctx.fillStyle = '#000000';
			ctx.fillRect(400, 0, 100, 100);
			ctx.rect(100, 100, 100, 100);
			ctx.fillStyle = '#ffff00';
			ctx.fillRect(100, 100, 100, 100);
			counter += 1;
			canvas.addEventListener('click', click1);
		}
	}
	async function click1() {
		if (counter == 1) {
			ctx.rect(200, 400, 100, 100);
			ctx.fillStyle = '#ff0000';
			ctx.fillRect(200, 400, 100, 100);
			await sleep(2);
			ctx.rect(300, 200, 300, 100);
			ctx.fillStyle = '#0000ff';
			ctx.fillRect(300, 200, 300, 100);
			ctx.rect(400, 300, 200, 100);
			ctx.fillStyle = '#00ffff';
			ctx.fillRect(400, 300, 200, 100);
			await sleep(4);
			ctx.rect(200, 100, 100, 100);
			ctx.fillStyle = '#ffc800';
			ctx.fillRect(200, 100, 100, 100);
			counter += 1;
			canvas.addEventListener('click', click2);
		}
	}
	async function click2() {
		if (counter == 2) {
			ctx.rect(100, 400, 100, 200);
			ctx.fillStyle = '#ff00ff';
			ctx.fillRect(100, 400, 100, 200);
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