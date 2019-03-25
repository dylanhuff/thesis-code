export {canvas as default};
export {ctx,window};
var canvas = document.createElement('canvas');
var ctx = canvas.getContext('2d');
var body = document.getElementsByTagName('body')[0];
class GWindow{
	constructor(width,height,borderStyle){
		this.width = width;
		this.height = height;
		this.borderStyle = borderStyle;
		this.renderOrder = []; //list of obj ids in render order
		this.objects = [];
	}
	renderWindow(){
	//renders the window without objects
		canvas.width = this.width;
		canvas.height = this.height;
		canvas.style.border = this.borderStyle;
		body.appendChild(canvas);
	}
	renderObject(id){
		//renders one object based on its id. should call the render method of the object
		this.objects.forEach(obj => {
			if(obj.id == id){
				obj.render();
				this.renderOrder.push(id);
			}
		});
	}
	derenderObject(id){
		var index = this.renderOrder.indexOf(id);
		this.renderOrder.splice(index,1);
		this.derenderAllObjects();
		this.renderAllObjects();
	}
	addObjects(objs){
		objs.forEach(element => {
			this.objects.push(element)
		});
	}
	renderAllObjects(){
		this.renderOrder.forEach(id => {
			this.objects.forEach(obj => {
				if(obj.id==id){
					obj.render();
				}
			});
		});
	}
	derenderAllObjects(){
		ctx.clearRect(0, 0, this.width, this.height);
		//iterate through all objects and change its renderBool to false
	}
}
class ObjectType{
	constructor(id,x,y){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	moveHelper(xOffset,yOffset){
		window.derenderAllObjects();
		this.x +=xOffset
		this.y +=yOffset;
		window.renderAllObjects();
	}
	move(endX,endY,duration){
		var _this = this;
		var xOffset = ((endX-this.x)/duration)/60; //px/refresh
		var yOffset = ((endY-this.y)/duration)/60;
		var threshold = (endX-this.x)/xOffset;
		var refreshCounter = 0;
		var intervalID = setInterval(function(){
			wrap();
		},1000/60);
		var wrap = function(){
			if(refreshCounter<threshold){
				_this.moveHelper(xOffset,yOffset);
				refreshCounter+=1;
			} else {
				clearInterval(intervalID)
			}
		}
	}
}
export class TextObj extends ObjectType{
	constructor(x,y,id,string,color,fontDesc){
		super(id,x,y);
		this.string = string;
		this.color = color;
		this.fontDesc = fontDesc;
	}
	render(){
		ctx.font = this.fontDesc;
		ctx.fillStyle = this.color;
		ctx.textAlign = 'center';
		ctx.fillText(this.string, this.x, this.y); 
	}
}
export class RectObj extends ObjectType{
	constructor(x,y,height,width,color,id){
		super(id,x,y);
		this.width = width;
		this.height = height;
		this.color = color;
	}
	render(){
		ctx.rect(this.x,this.y,this.height,this.width);
		ctx.fillStyle = this.color;
		ctx.fillRect(this.x,this.y,this.height,this.width);
	}
}
export class OvalObj extends ObjectType{
	constructor(x,y,radiusX, radiusY, rotation, startAngle, endAngle ,color,id){
		super(id,x,y);
		this.radiusX = radiusX;
		this.radiusY = radiusY;
		this.rotation = rotation;
		this.startAngle = startAngle;
		this.endAngle = endAngle;
		this.color = color;
	}
	render(){
		ctx.beginPath();
		ctx.ellipse(this.x,this.y,this.radiusX,this.radiusY,this.rotation,this.startAngle,this.endAngle);
		ctx.fillStyle = this.color;
		ctx.fill();
	}
}
var window = new GWindow(716,537,'1px solid');
