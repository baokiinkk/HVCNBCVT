package com.baokiiin.hvcnbcvt.ui.student.home

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.baokiiin.hvcnbcvt.R
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.components.XAxis
import java.text.DecimalFormat
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.formatter.IFillFormatter
import com.github.mikephil.charting.formatter.ValueFormatter
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_home.view.*


@AndroidEntryPoint
class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val bd = inflater.inflate(R.layout.fragment_home, container, false)

        val entries = ArrayList<Entry>()
        for (i in 0 until 10) {
            entries.add(Entry(i.toFloat(), i*2f))
        }
        val hocki = ArrayList<String>()
        for (i in 0 until 10) {
            hocki.add("aaaa")
        }

        class DataValueFormatter : ValueFormatter() {
            private val format = DecimalFormat("###,##0.00")

            // override this for e.g. LineChart or ScatterChart
            override fun getPointLabel(entry: Entry?): String {
                return format.format(entry?.y)
            }
        }

        val xAxis = bd.linechart.xAxis
        xAxis.granularity = 1f
        xAxis.setDrawLabels(false)
        xAxis.setDrawGridLines(false)
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        val yAxisL = bd.linechart.axisLeft
        yAxisL.setDrawGridLines(false)
        yAxisL.textColor = Color.rgb(175, 175, 175)
        yAxisL.mAxisMaximum = 4.0f
        yAxisL.granularity = 0.1f
        val dataset = LineDataSet(entries, "Điểm Tích Lũy")
        dataset.setDrawFilled(true)
        ////dataset.fillColor = Color.rgb(99, 80, 200)
        dataset.mode = LineDataSet.Mode.CUBIC_BEZIER
        dataset.lineWidth = 3f
        dataset.valueFormatter = DataValueFormatter()
        dataset.valueTextSize = 8f
        dataset.circleRadius = 6f
        dataset.circleHoleRadius = 3f
        dataset.cubicIntensity = 0.2f
        dataset.valueTextColor = Color.rgb(0, 215, 193)
        dataset.color = Color.rgb(0, 215, 193)
        dataset.setCircleColor(Color.argb(40, 0, 235, 213))
        dataset.circleHoleColor = Color.rgb(0, 215, 193)
        dataset.fillFormatter =
            IFillFormatter { _, _ -> bd.linechart.axisLeft.axisMinimum }

        // set color of filled area
        val drawable: Drawable? =
            context?.let { it1 -> ContextCompat.getDrawable(it1, R.drawable.fade_graph) }
        context?.apply {

        }
        dataset.fillDrawable = drawable


        val data: ArrayList<ILineDataSet> = ArrayList()
        data.add(dataset)
        val lineData = LineData(data)
        val des = Description()
        des.text = ""

        val legend = bd.linechart.legend
        legend.isEnabled = false

        bd.linechart.axisRight.isEnabled = false
        bd.linechart.data = lineData
        bd.linechart.setDrawBorders(false)
//                bd.linechart.setBorderColor(Color.BLACK)
//                bd.linechart.setBorderWidth(1f)
        bd.linechart.description = des
        bd.linechart.setScaleEnabled(false)
        bd.linechart.isDoubleTapToZoomEnabled = false
        bd.linechart.setTouchEnabled(true)
        bd.linechart.isHighlightPerDragEnabled = false
        bd.linechart.isHighlightPerTapEnabled = true
        val mv = CustomMarkerView(
            context,
            R.layout.axis_label,
            hocki,
            bd.linechart.width,
            bd.linechart.height
        )
        bd.linechart.marker = mv
        bd.linechart.invalidate()
        return bd
    }

}