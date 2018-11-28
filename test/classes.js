export {RectObj as default};
import ctx from './example.js'
class RectObj{
	constructor(x,y,height,width,color){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
	}
	renderRect(){
		ctx.rect(this.x,this.y,this.height,this.width);
		ctx.fillStyle = this.color;
		ctx.fillRect(this.x,this.y,this.height,this.width);
	}
	clearRect(){
		ctx.clearRect(this.x, this.y, this.height, this.width);
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
