function testSave(){
	var canvas = document.createElement('canvas');
	canvas.width = '716';
	canvas.height = '537';
	canvas.style.border = '1px solid';
	var body = document.getElementsByTagName('body')[0];
	body.appendChild(canvas);
	var ctx = canvas.getContext('2d');
	ctx.rect(400,0,100,100);
	ctx.fillStyle = '#000000';
	ctx.fillRect(400,0,100,100);
	ctx.rect(100,100,100,100);
	ctx.fillStyle = '#000000';
	ctx.fillRect(100,100,100,100);
	ctx.rect(300,200,300,100);
	ctx.fillStyle = '#000000';
	ctx.fillRect(300,200,300,100);
	ctx.rect(0,200,300,100);
	ctx.fillStyle = '#ff0000';
	ctx.fillRect(0,200,300,100);
	ctx.stroke();
}