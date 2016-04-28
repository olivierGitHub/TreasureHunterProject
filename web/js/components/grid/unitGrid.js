var React = require('react');

var UnitGrid = React.createClass({

    render: function () {
        return (
            <span className={this.props.typeUnitGrid} id={this.props.position} ></span>
        );
    }
});


module.exports = UnitGrid;
