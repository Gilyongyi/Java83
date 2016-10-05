<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<style>

body {
  margin: 0;
  background: #ffffff;
  min-width: 960px;
}

rect {
  fill: none;
  pointer-events: all;
}

circle {
  fill: none;
  stroke-width: 2.5px;
}

</style>
<body>
<script src="//d3js.org/d3.v3.min.js"></script>
<script>

var width = Math.max(960, innerWidth),
    height = Math.max(500, innerHeight);

var i = 0;

var svg = d3.select("body").append("svg")
    .attr("width", width)
    .attr("height", height);

svg.append("rect")
    .attr("width", width)
    .attr("height", height)
    .on("ontouchstart" in document ? "touchmove" : "mousemove", particle);

function particle() {
  var m = d3.mouse(this);

  svg.insert("circle", "rect")
      .attr("cx", m[0])
      .attr("cy", m[1])
      .attr("r", 1e-6)
      .style("stroke", d3.hsl((i = (i + 1) % 360), 1, .5))
      .style("stroke-opacity", 1)
    .transition()
      .duration(5000)
      .ease(Math.sqrt)
      .attr("r", 100)
      .style("stroke-opacity", 1e-6)
      .remove();

  d3.event.preventDefault();
}

</script>
</head>
<body>

</body>
</html>