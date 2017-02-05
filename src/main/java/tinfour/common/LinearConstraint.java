/* --------------------------------------------------------------------
 * Copyright 2016 Gary W. Lucas.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ---------------------------------------------------------------------
 */

 /*
 * -----------------------------------------------------------------------
 *
 * Revision History:
 * Date     Name         Description
 * ------   ---------    -------------------------------------------------
 * 10/2016  G. Lucas     Created
 * 01/2016  G. Lucas     Fixed bounds bug reported by Martin Janda
 *
 * Notes:
 *
 * -----------------------------------------------------------------------
 */
package tinfour.common;

/**
 * An implementation of the IConstraint interface intended to store
 * constraints comprised of a chain of connected line segments.
 * Constraint chains must be non-self-intersecting (except at segment
 * endpoints). The chain must never "fold back" on itself. All segments
 * in the chain must be non-zero-length.
 * Do not use this class for closed polygons.
 */
public class LinearConstraint extends PolyLineConstraintAdapter implements IConstraint {

  @Override
  public void complete() {
    // at this time, do nothing
  }

  @Override
  public boolean isPolygon() {
    return false;
  }

  @Override
  public void setDefinesDataArea(boolean definesDataArea) {
    if (definesDataArea) {
      throw new IllegalArgumentException(
        "A non-polygon constraint cannot define a data area.");
    }
  }

  /**
   * Indicates whether the constraint defines a data area.
   * Because linear constraints cannot define an area, this method
   * always returns false.
   *
   * @return always false for linear constraints.
   */
  @Override
  public boolean definesDataArea() {
    return false;
  }

}
