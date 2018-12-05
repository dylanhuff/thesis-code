export {RectObj as default};
export {canvas,ctx,window};
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
class RectObj{
	constructor(x,y,height,width,color,id){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.id = id;
	}
	render(){
		ctx.rect(this.x,this.y,this.height,this.width);
		ctx.fillStyle = this.color;
		ctx.fillRect(this.x,this.y,this.height,this.width);
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
var window = new GWindow(716,537,'1px solid');
