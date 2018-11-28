import RectObj from './classes.js';
var canvas = document.createElement('canvas');
var ctx = canvas.getContext('2d');
export {ctx as default};
var rect2 = new RectObj(400,0,100,100,"#000000");
var rect3 = new RectObj(110,110,100,100,"#ffff00");
var rect4 = new RectObj(300,200,300,100,"#0000ff");
var rect5 = new RectObj(200,400,100,100,"#ff0000");
var rect6 = new RectObj(200,100,100,100,"#ffc800");
var rect7 = new RectObj(400,300,200,100,"#00ffff");
var rect8 = new RectObj(100,400,100,200,"#ff00ff");
function testSave(){
	document.removeEventListener('load',testSave);
	canvas.width = '716';
	canvas.height = '537';
	canvas.style.border = '1px solid';
	var body = document.getElementsByTagName('body')[0];
	body.appendChild(canvas);
	function sleep(s)
 	{return new Promise(resolve => setTimeout(resolve, s*1000));
	}
	var counter = 0;
	canvas.addEventListener('click', click0);
	async function click0(){
		if (counter==0){
	rect2.renderRect();
	rect3.renderRect();
	counter+=1;
	canvas.addEventListener('click', click1);
	}}
	async function click1(){
		if (counter==1){
	rect5.renderRect();
	await sleep(1);
	rect4.renderRect();
	rect7.renderRect();
	await sleep(1);
	rect6.renderRect();
	counter+=1;
	canvas.addEventListener('click', click2);
	}}
	async function click2(){
		if (counter==2){
	rect8.renderRect();
	await sleep(0);
	rect3.moveWrapper(1000/60);	counter+=1;
	canvas.addEventListener('click', click3);
	}}
	ctx.beginPath();
	ctx.ellipse(300.0,300.0,100.0,50.0,0,0,6.283185307179586);
	ctx.fillStyle = '#ffffff';
	ctx.fill();
	ctx.moveTo(300,300);
	ctx.lineTo(0,0);
	ctx.stroke();
}
document.addEventListener('load', testSave());
