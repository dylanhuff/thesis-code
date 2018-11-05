function testSave(){
	var canvas = document.createElement('canvas');
	canvas.width = '716';
	canvas.height = '537';
	canvas.style.border = '1px solid';
	var body = document.getElementsByTagName('body')[0];
	body.appendChild(canvas);
	var ctx = canvas.getContext('2d');
	ctx.beginPath();
	ctx.ellipse(300.0,300.0,100.0,50.0,0,0,6.283185307179586);
	ctx.fillStyle = '#ffffff';
	ctx.fill();
	canvas.addEventListener('click', function() {
		ctx.rect(400,0,100,100);
		ctx.fillStyle = '#000000';
		ctx.fillRect(400,0,100,100);
	}, false);
	ctx.rect(100,100,100,100);
	ctx.fillStyle = '#ffff00';
	ctx.fillRect(100,100,100,100);
	ctx.rect(300,200,300,100);
	ctx.fillStyle = '#0000ff';
	ctx.fillRect(300,200,300,100);
	ctx.rect(200,400,100,100);
	ctx.fillStyle = '#ff0000';
	ctx.fillRect(200,400,100,100);
	ctx.moveTo(300,300);
	ctx.lineTo(0,0);
	ctx.stroke();
}