var React = require('react');
var UnitGrid = require('./unitGrid.js');


var UnitGridGroup = React.createClass({

    render: function () {
        var i = 0;
        return (
            <div>
            {
                this.props.gridInformation.map(function (unitGrid){
                    ++i;

                    if ( i%6 ==0) {
                        return (
                            <span>
                                <UnitGrid typeUnitGrid={unitGrid.typeUnitGrid} position={unitGrid.position} key={unitGrid.position} />
                                <p className="clear"></p>
                            </span>
                        )
                    }

                    return (
                        <UnitGrid typeUnitGrid={unitGrid.typeUnitGrid} position={unitGrid.position} key={unitGrid.position} />

                    )
                })
            }
            </div>
        );
    }
});


module.exports = UnitGridGroup;
