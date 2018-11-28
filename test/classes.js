export {RectObj as default};
export {canvas,ctx,GWindow};
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
		this.renderOrder.forEach(id => {			this.objects.forEach(obj => {
				if(obj.id==id){
					obj.render();
				}
			});
		});
	}
	derenderAllObjects(){
		ctx.clearRect(0, 0, this.height, this.width);
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
	move(){
		this.clearRect();
		this.x = this.x;
		this.y -=1;
		this.renderRect();
	}
	moveWrapper(interval){
		var _this = this;
		setInterval(function(){
			_this.move();
		},interval);
	}
}
